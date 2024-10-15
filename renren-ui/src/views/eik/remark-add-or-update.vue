<template>
  <el-dialog v-model="visible" :title="!dataForm.id ? '新增' : '修改'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
          <el-form-item label="" prop="enterprise">
        <el-input v-model="dataForm.enterprise" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="company">
        <el-input v-model="dataForm.company" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="companyadmin">
        <el-input v-model="dataForm.companyadmin" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="detail">
        <el-input v-model="dataForm.detail" placeholder=""></el-input>
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
  id: '',  enterprise: '',  company: '',  companyadmin: '',  detail: ''});

const rules = ref({
          enterprise: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          company: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          companyadmin: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          detail: [
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
  baseService.get("/demo/remark/" + id).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

// 表单提交
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      return false;
    }
    (!dataForm.id ? baseService.post : baseService.put)("/demo/remark", dataForm).then((res) => {
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
