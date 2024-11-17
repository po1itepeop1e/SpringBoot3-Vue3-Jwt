<script setup>

</script>

<template>
  <div style="width: 100vw;height: 100vh;overflow: hidden;display: flex">
    <div style="flex: 1; background-color: black">
      <el-image style="width: 100%;height: 100%" fit="cover"
          src="https://img0.baidu.com/it/u=1700721836,1143231507&fm=253&fmt=auto&app=120&f=JPEG?w=1023&h=667">
      </el-image>
    </div>
    <div class="welcome-title">
      <div style="font-size: 30px;font-weight: bold">欢迎来到田园猫的家!</div>
      <div style="margin-top: 10px">在这里建设猫星</div>
      <div style="margin-top: 5px">在这里抓捕老鼠</div>
      <div style="margin-top: 5px">在这里收获快乐吧!</div>
    </div>
    <div class="right-card">
      <router-view v-slot="{ Component}">
        <transition name="el-fade-in-linear" mode="out-in">
          <component :is="Component"/>
        </transition>
      </router-view>
    </div>
  </div>
</template>

<style scoped>
.right-card {
  width: 400px;
  z-index: 1;
  background-color: var(--el-bg-color);
}

.welcome-title {
  position: absolute;
  bottom: 30px;
  left: 30px;
  color: white;
  text-shadow: 0 0 10px black;
}

</style>