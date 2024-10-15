<template>
  <el-dialog v-model="visible" :title="!dataForm.id ? '新增' : '修改'" :close-on-click-modal="false"
    :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
      <el-form-item label="时间" prop="time">
        <!-- <el-input v-model="dataForm.time" placeholder=""></el-input> -->
        <el-date-picker v-model="dataForm.time" value-format="YYYY-MM-DD HH:mm:ss" type="datetime" placeholder="选择日期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="温度" prop="wendu">
        <el-input v-model="dataForm.wendu" placeholder=""></el-input>
      </el-form-item>
      <!--
          <el-form-item label="" prop="type">
        <el-input v-model="dataForm.type" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="createTime">
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

const dataForm = reactive({
  id: '', time: '', wendu: '', type: '', createTime: ''
});

const rules = ref({
  time: [
    { required: true, message: '必填项不能为空', trigger: 'blur' }
  ],
  wendu: [
    { required: true, message: '必填项不能为空', trigger: 'blur' }
  ],
  type: [
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
  baseService.get("/demo/thermal/" + id).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

// 表单提交
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      return false;
    }
    (!dataForm.id ? baseService.post : baseService.put)("/demo/thermal", dataForm).then((res) => {
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
