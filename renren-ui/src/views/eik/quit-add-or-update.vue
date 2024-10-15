<template>
  <el-dialog v-model="visible" :title="!dataForm.id ? '新增' : '修改'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
          <el-form-item label="" prop="companyid">
        <el-input v-model="dataForm.companyid" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="studentid">
        <el-input v-model="dataForm.studentid" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="quittime">
        <el-input v-model="dataForm.quittime" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="quitreason">
        <el-input v-model="dataForm.quitreason" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="companyname">
        <el-input v-model="dataForm.companyname" placeholder=""></el-input>
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
  id: '',  companyid: '',  studentid: '',  quittime: '',  quitreason: '',  companyname: ''});

const rules = ref({
          companyid: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          studentid: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          quittime: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          quitreason: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          companyname: [
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
  baseService.get("/demo/quit/" + id).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

// 表单提交
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      return false;
    }
    (!dataForm.id ? baseService.post : baseService.put)("/demo/quit", dataForm).then((res) => {
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
