<template>
  <el-dialog v-model="visible" :title="!dataForm.id ? '新增' : '修改'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
          <el-form-item label="传感器类型" prop="type">
        <el-input v-model="dataForm.type" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="选择鸡舍" prop="henId">
            <el-select v-model="dataForm.henId" filterable placeholder="选择鸡舍" >
                <el-option v-for="item in optionType" :key="item.id" :label="item.name" :value="item.id">
                </el-option>
              </el-select>
      </el-form-item>
          <el-form-item label="安装位置" prop="weizhi">
        <el-input v-model="dataForm.weizhi" placeholder="安装位置"></el-input>
      </el-form-item>
          <!-- <el-form-item label="" prop="createTime">
        <el-input v-model="dataForm.createTime" placeholder=""></el-input>
      </el-form-item> -->
      </el-form>
    <template #footer>
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmitHandle()">确定</el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import { reactive, ref } from "vue";
import baseService from "@/service/baseService";
import { ElMessage } from "element-plus";
const emit = defineEmits(["refreshDataList"]);

const visible = ref(false);
const dataFormRef = ref();
const optionType=reactive([]);
const dataForm = reactive({
  id: '',  type: '',  henId: '',  weizhi: '',  createTime: ''});

const rules = ref({
          type: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          henId: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          weizhi: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          createTime: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ]
  });

const init = (id?: number) => {
  visible.value = true;
  dataForm.id = "";

  // 重置表单数据
  if (dataFormRef.value) {
    dataFormRef.value.resetFields();
  }

  if (id) {
    getInfo(id);
  }
  getHenList()
};

// 获取信息
const getInfo = (id: number) => {
  baseService.get("/demo/sensor/" + id).then((res) => {
    Object.assign(dataForm, res.data);
  });
};
const getHenList = () => {
  baseService.get("/demo/henhouse/getList").then((res) => {
    console.log(res)
    Object.assign(optionType, res.data);
    // optionType=res.data
  });
};
// 表单提交
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      return false;
    }
    (!dataForm.id ? baseService.post : baseService.put)("/demo/sensor", dataForm).then((res) => {
      ElMessage.success({
        message: '成功',
        duration: 500,
        onClose: () => {
          visible.value = false;
          emit("refreshDataList");
        }
      });
    });
  });
};

defineExpose({
  init
});
</script>
