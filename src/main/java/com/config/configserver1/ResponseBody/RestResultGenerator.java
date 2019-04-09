package com.config.configserver1.ResponseBody;

import java.util.logging.Logger;

public class RestResultGenerator {
   // private static final Logger LOGGER = LoggerFactory.getLogger(RestResultGenerator.class);


    /**
     * 生成响应成功(带正文)的结果
     *
     * @param data    结果正文
     * @param message 成功提示信息
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> genResult(T data, String message) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setSuccess(true);
        result.setData(data);
        result.setMessage(message);
//        if (LOGGER.isDebugEnabled()) {
//            LOGGER.debug("--------> result:{}", JacksonMapper.toJsonString(result));
//        }
        return result;
    }

    /**
     * 生成响应失败(带errorCode)的结果
     *
     * @param errCode 失败信息
     * @return ResponseResult
     */
    public static <T>ResponseResult<T> genErrorResult(String errCode) {
        ResponseResult result = new ResponseResult<T>();
        result.setSuccess(false);
        result.setErrorCode(errCode);


        return result;
    }
}
