<template>
  <div class="mod-sys__menu">
    <el-form :inline="true" :model="state.dataForm" @keyup.enter="state.getDataList()">
      <el-form-item>
        <el-button v-if="state.hasPermission('sys:menu:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="state.dataListLoading" :data="state.dataList" show-overflow-tooltip row-key="id" border style="width: 100%">
      <el-table-column prop="name" label="内容" header-align="center" min-width="150"></el-table-column>
      <el-table-column prop="url" label="楼主" header-align="center" align="center" width="150"></el-table-column>
      <el-table-column prop="permissions" label="用户" header-align="center" align="center" width="150"></el-table-column>
      <el-table-column label="操作" fixed="right" header-align="center" align="center" width="170">
        <template v-slot="scope">
          <el-button v-if="state.hasPermission('sys:menu:save') && scope.row.menuType === 0" type="primary" link @click="addHandle(scope.row)">新增</el-button>
          <el-button v-if="state.hasPermission('sys:menu:update')" type="primary" link @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button v-if="state.hasPermission('sys:menu:delete')" type="primary" link @click="state.deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update ref="addOrUpdateRef" @refreshDataList="state.getDataList"></add-or-update>
  </div>
</template>

<script lang="ts" setup>
import useView from "@/hooks/useView";
import { reactive, ref, toRefs } from "vue";
import AddOrUpdate from "./pinglun-add-or-update.vue";

const view = reactive({
  getDataListURL: "/sys/pinglun/list",
  deleteURL: "/sys/pinglun"
});

const state = reactive({ ...useView(view), ...toRefs(view) });

const addOrUpdateRef = ref();
const addOrUpdateHandle = (id?: number) => {
  addOrUpdateRef.value.init(id);
};

const addHandle = (row: any) => {
  addOrUpdateRef.value.init2(row);
};
</script>
