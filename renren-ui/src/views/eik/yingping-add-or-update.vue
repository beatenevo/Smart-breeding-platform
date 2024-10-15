<template>
  <el-dialog v-model="visible" :title="!dataForm.id ? '新增' : '修改'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
          <!-- <el-form-item label="" prop="enterpriseid">
        <el-input v-model="dataForm.enterpriseid" placeholder=""></el-input>
      </el-form-item> -->
          <!-- <el-form-item label="公司名称" prop="enterprisename">
        <el-input v-model="dataForm.enterprisename" placeholder=""></el-input>
      </el-form-item> -->
          <el-form-item label="申请简介" prop="yuanyin">
        <el-input v-model="dataForm.yuanyin" placeholder=""></el-input>
      </el-form-item>
          <!-- <el-form-item label="" prop="type">
        <el-input v-model="dataForm.type" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="" prop="available">
        <el-input v-model="dataForm.available" placeholder=""></el-input>
      </el-form-item> -->
          <!-- <el-form-item label="联系电话" prop="telephone">
        <el-input v-model="dataForm.telephone" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="薪资" prop="salary">
        <el-input v-model="dataForm.salary" placeholder=""></el-input>
      </el-form-item>
          <el-form-item label="工作时间" prop="worktime">
        <el-input v-model="dataForm.worktime" placeholder=""></el-input>
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
  id: '',  yuanyin: ''});

const rules = ref({
          enterpriseid: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          enterprisename: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
    yuanyin: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          type: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          available: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          telephone: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          salary: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          worktime: [
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
    // getInfo(id);
   dataForm.id=id+""
  }
};

// 获取信息
const getInfo = (id: number) => {
  baseService.get("/demo/company/" + id).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

// 表单提交
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      return false;
    }
    baseService.post("/demo/companyuser", dataForm).then((res) => {
      ElMessage.success({
        message: '申请成功',
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
