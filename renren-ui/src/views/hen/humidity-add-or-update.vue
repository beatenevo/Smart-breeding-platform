<template>
  <el-dialog v-model="visible" :title="!dataForm.id ? '新增' : '修改'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
          <el-form-item label="时间" prop="time">
            <el-select v-model="dataForm.time" filterable placeholder="选择日期" >
                <el-option label="周一" value="周一"></el-option>
                <el-option label="周二" value="周二"></el-option>
                <el-option label="周三" value="周三"></el-option>
                <el-option label="周四" value="周四"></el-option>
                <el-option label="周五" value="周五"></el-option>
                <el-option label="周六" value="周六"></el-option>
                <el-option label="周日" value="周日"></el-option>
              </el-select>
      </el-form-item>
          <el-form-item label="湿度" prop="shidu">
        <el-input v-model="dataForm.shidu" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="类型" prop="type">
            <el-select v-model="dataForm.type" filterable placeholder="选择类型" >
                <el-option label="最大湿度" value="最大湿度"></el-option>
                <el-option label="平均湿度" value="平均湿度"></el-option>
                <el-option label="最小湿度" value="最小湿度"></el-option>
                
              </el-select>
      </el-form-item>
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

const dataForm = reactive({
  id: '',  time: '',  shidu: '',  createTime: '',type:''});

const rules = ref({
          time: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          shidu: [
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
};

// 获取信息
const getInfo = (id: number) => {
  baseService.get("/demo/humidity/" + id).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

// 表单提交
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      return false;
    }
    (!dataForm.id ? baseService.post : baseService.put)("/demo/humidity", dataForm).then((res) => {
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
