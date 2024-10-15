<template>
  <el-dialog v-model="visible" :title="!dataForm.username ? '新增' : '修改'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
          <el-form-item label="" prop="id">
        <el-input v-model="dataForm.id" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="password">
        <el-input v-model="dataForm.password" placeholder=""></el-input>
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
  username: '',  id: '',  password: ''});

const rules = ref({
          id: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          password: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ]
  });

const init = (username?: number) => {
  visible.value = true;
  dataForm.username = "";

  // 重置表单数据
  if (dataFormRef.value) {
    dataFormRef.value.resetFields();
  }

  if (username) {
    getInfo(username);
  }
};

// 获取信息
const getInfo = (username: number) => {
  baseService.get("/demo/manager/" + username).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

// 表单提交
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      return false;
    }
    (!dataForm.username ? baseService.post : baseService.put)("/demo/manager", dataForm).then((res) => {
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
