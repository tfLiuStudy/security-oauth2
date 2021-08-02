# 授权服务
授权服务 (Authorization Server）应包含对接入端以及登入用户的合法性进行验证并颁发token等功能，对令牌
的请求端点由 Spring MVC 控制器进行实现，下面是配置一个认证服务必须要实现的endpoints：

```
AuthorizationEndpoint 服务于认证请求。默认 URL： /oauth/authorize 。
TokenEndpoint 服务于访问令牌的请求。默认 URL： /oauth/token 。
```
## 认证流程如下：
```
1、客户端请求UAA授权服务进行认证。
2、认证通过后由UAA颁发令牌。
3、客户端携带令牌Token请求资源服务。
4、资源服务校验令牌的合法性，合法即返回资源信息。
```

