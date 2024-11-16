<script setup>
import {Lock, User} from '@element-plus/icons-vue'
import {reactive, ref} from "vue";
import {login} from "@/net";
import router from "@/router";


const form =reactive( {
    username: '',
    password: '',
    remember: false
    }
)

const formRef = ref()

const rule = {
  username: [
    {require: true, message: '输入代号'}
  ],
  password: [
    {require: true, message: '输入口令'}
  ]
}

function userLogin() {
  formRef.value.validate((valid) => {
    if(valid) {
      login(form.username, form.password, form.remember, () => router.push("/index"))
    }
  })
}

</script>

<template>
  <div style="text-align: center;margin: 0 20px">
    <div style="margin-top: 150px">
      <div style="font-size: 25px;font-weight: bold">登录</div>
      <div style="font-size: 14px;color: grey">进入系统，请输入代号与口令</div>
    </div>
    <div style="margin-top: 50px">
      <el-form :model="form" :rules="rule" ref="formRef">
        <el-form-item prop="username">
          <el-input v-model="form.username" maxlength="10" type="text" placeholder="代号">
            <template #prefix>
              <el-icon><User/></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="form.password" type="password" maxlength="20" placeholder="口令">
            <template #prefix>
              <el-icon><Lock/></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-row>
          <el-col :span="12" style="text-align: left">
            <el-form-item prop="remember">
              <el-checkbox v-model="form.remember" label="保持登录">

              </el-checkbox>
            </el-form-item>
          </el-col>
          <el-col :span="12" style="text-align: right">
            <el-link @click="router.push('/reset')">忘记密码</el-link>
          </el-col>
        </el-row>
      </el-form>
    </div>
    <div style="margin-top: 40px">
      <el-button @click="userLogin()" style="width: 270px" type="success">立即登录</el-button>
    </div>
    <el-divider>
      <span style="font-size: 13px;color: grey">
        没有代号
      </span>
    </el-divider>
    <div>
      <el-button @click="router.push('/register')" style="width: 270px" type="warning" plain>立即登记</el-button>
    </div>
  </div>
</template>

<style scoped>

</style>