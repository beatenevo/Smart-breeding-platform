<template>
  <el-dialog v-model="visible" :title="!dataForm.number ? '新增' : '修改'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
          <el-form-item label="" prop="enterprise">
        <el-input v-model="dataForm.enterprise" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="company">
        <el-input v-model="dataForm.company" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="details">
        <el-input v-model="dataForm.details" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="time">
        <el-input v-model="dataForm.time" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="salary">
        <el-input v-model="dataForm.salary" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="state">
        <el-input v-model="dataForm.state" placeholder=""></el-input>
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
  number: '',  enterprise: '',  company: '',  details: '',  time: '',  salary: '',  state: ''});

const rules = ref({
          enterprise: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          company: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          details: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          time: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          salary: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          state: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ]
  });

const init = (number?: number) => {
  visible.value = true;
  dataForm.number = "";

  // 重置表单数据
  if (dataFormRef.value) {
    dataFormRef.value.resetFields();
  }

  if (number) {
    getInfo(number);
  }
};

// 获取信息
const getInfo = (number: number) => {
  baseService.get("/demo/notice/" + number).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

// 表单提交
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      return false;
    }
    (!dataForm.number ? baseService.post : baseService.put)("/demo/notice", dataForm).then((res) => {
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
