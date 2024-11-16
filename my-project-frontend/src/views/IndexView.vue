<script setup>
 import {logout} from "@/net";
 import router from "@/router";
 function userLogout() {
   logout(() => router.push("/"))
 }
</script>

<template>
  <div>
    <el-button @click="userLogout">退出登录</el-button>
  </div>

  <div style="flex: 1; background-color: black">
    <el-image style="width: 100%;height: 100%" fit="cover"
              src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2Faa3f534b-e373-4e42-8174-2843acbbabc6%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1734318910&t=62b208c4ee211c736e43294b5aa21e6c">
    </el-image>
  </div>

</template>

<style scoped>

</style>