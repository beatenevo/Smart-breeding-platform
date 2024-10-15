<template>
  <el-dialog v-model="visible" :title="!dataForm.id ? '新增' : '修改'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
          <el-form-item label="鸡舍名称" prop="name">
        <el-input v-model="dataForm.name" placeholder="鸡舍名称"></el-input>
      </el-form-item>
          <el-form-item label="鸡舍位置" prop="weizhi">
        <el-input v-model="dataForm.weizhi" placeholder="鸡舍位置"></el-input>
      </el-form-item>
          <el-form-item label="鸡舍面积" prop="mianji">
        <el-input v-model="dataForm.mianji" placeholder="鸡舍面积"></el-input>
      </el-form-item>
          <el-form-item label="数量" prop="number">
        <el-input v-model="dataForm.number" placeholder="数量"></el-input>
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
  id: '',  name: '',  weizhi: '',  mianji: '',  number: ''});

const rules = ref({
          name: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          weizhi: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          mianji: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          number: [
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
  baseService.get("/demo/henhouse/" + id).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

// 表单提交
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      return false;
    }
    (!dataForm.id ? baseService.post : baseService.put)("/demo/henhouse", dataForm).then((res) => {
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
