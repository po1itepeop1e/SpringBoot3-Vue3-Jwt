package com.example.controller;

import com.example.entity.RestBean;
import com.example.entity.vo.request.ConfirmResetVO;
import com.example.entity.vo.request.EmailRegisterVO;
import com.example.entity.vo.request.EmailResetVO;
import com.example.service.AccountService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Validated
@RestController
@RequestMapping("/api/auth")
public class AuthorizeController {

    @Resource
    AccountService service;

    @GetMapping("/ask-code")
    public RestBean<Void> askVersifyCode(@RequestParam @Email String email,
                                         @RequestParam @Pattern(regexp = "(register|reset)") String type,
                                         HttpServletRequest request) {

        return this.messageHandle(() ->
                service.registerEmailVerifyCode(type, email, request.getRemoteAddr()));
    }

    @PostMapping("/register")
    public RestBean<Void> register(@RequestBody @Valid EmailRegisterVO vo){
            return this.messageHandle(() ->
                    service.registerEmailAccount(vo));
    }

    @PostMapping("/reset-confirm")
    public RestBean<Void> resetConfirm(@RequestBody @Valid ConfirmResetVO vo){
        return this.messageHandle(vo, service::restConfirm);
    }

    @PostMapping("/reset-password")
    public RestBean<Void> resetConfirm(@RequestBody @Valid EmailResetVO vo){
        return this.messageHandle(vo, service::resetEmailAccountPassword);
    }

    private <T> RestBean<Void> messageHandle(T vo, Function<T, String> function) {
        return messageHandle(() -> function.apply(vo));
    }

    public RestBean<Void> messageHandle(Supplier<String> action){
        String message = action.get();
        return message == null ? RestBean.success() : RestBean.failure(400, message);
    }
}
