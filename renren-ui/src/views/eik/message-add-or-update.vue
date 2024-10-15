<template>
  <el-dialog v-model="visible" :title="!dataForm.messageid ? '新增' : '修改'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
          <el-form-item label="标题" prop="title">
        <el-input v-model="dataForm.title" placeholder="标题"></el-input>
      </el-form-item>
          <el-form-item label="内容" prop="content">
        <el-input v-model="dataForm.content" placeholder="内容"></el-input>
      </el-form-item>
          <el-form-item label="楼主" prop="writer">
        <el-input v-model="dataForm.writer" placeholder="楼主"></el-input>
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
  id:'',messageid: '',  title: '',  content: '',  writer: ''});

const rules = ref({
          title: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          content: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          writer: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ]
  });

const init = (messageid?: number) => {
  visible.value = true;
  dataForm.messageid = "";

  // 重置表单数据
  if (dataFormRef.value) {
    dataFormRef.value.resetFields();
  }

  if (messageid) {
    getInfo(messageid);
  }
};

// 获取信息
const getInfo = (messageid: number) => {
  baseService.get("/demo/message/" + messageid).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

// 表单提交
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      return false;
    }
    (!dataForm.messageid ? baseService.post : baseService.put)("/demo/message", dataForm).then((res) => {
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
