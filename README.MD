### 接口参数
1. 网关接收的请求的参数格式(json格式)  
{  
"version":"1.0",  
"token":"xxx(可以是纯token或者签名)",  
"sendTime":"yyyy-MM-dd HH:mm:ss:SSS",  
"data":"实际的数据,json格式"  
}  

2. 网关返回的数据格式(json格式)  
{  
"version":"1.0",  
"gwCode":"0000",  
"gwMsg":"网关请求成功",  
"response":"实际业务方返回的数据"    
}

