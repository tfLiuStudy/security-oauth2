# 资源服务
资源服务 (Resource Server)，应包含对资源的保护功能，对非法请求进行拦截，对请求中token进行解析鉴
权等，下面的过滤器用于实现 OAuth 2.0 资源服务：
```
OAuth2AuthenticationProcessingFilter用来对请求给出的身份令牌解析鉴权。
```
