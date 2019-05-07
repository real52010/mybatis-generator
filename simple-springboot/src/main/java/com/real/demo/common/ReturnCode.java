package com.real.demo.common;

public enum ReturnCode {
    /**
     * 000000-000099 操作结果成常保留区
     */
    SUCCESS("000000", "操作成功"),

    // FAILED("000100", "操作失败"),
    /**
     * 000100-019999 系统异常
     */
    SYSTEM_ERROR("000100", "系统异常"),
    SERVICE_ERROR("000101", "服务层发生异常"),
    CONTROLLER_ERROR("000102", "控制层发生异常"),
    DATA_ERROR("000103", "数据异常，预期数据未返回"),
    DATA_BASE_ERROR("000999", "数据库异常"),

    /**
     * 100000-199999 系统保留
     */
    /**
     * 接口参数 定时任务异常
     * 200000-299999 系统保留
     */


	
	PARAM_EMPTY("200001", "请求参数为空"),

	PARAM_FORMAT_ERROR("200001", "请求参数格式错误"),
	SMS_SEND_ERROR("200004", "短信发送失败"),
    /**
     * 400000-409999 agent
     */
    LOGIN_SESSION_OUT("400001", "您未登录或登录已过期,请先登录后操作."),

	AGENT_NOT_REGIST("400002", "您的手机号没有注册或输入有误，请确认后再试！"),
	
	AGENT_IS_REGIST("400003", "您已注册，请去登录！"),
	
	NOT_GET_AGENT_OPENID("400004", "操作失败,请刷新后再试！"),
	
	NOT_GET_ACCESSTOKEN("400005", "没有获取微信access_token"),
	
	NOT_GET_WECHAT_INFO("400006", "没有获取到微信信息"),
	
	NOT_GET_AGENT_INFO("400007","您的信息不完整，请联系我们"),
	
	GET_PICTURE_VALIDATION_FAIL("400008","获取图形验证码失败"),
	
	PICTURE_VALIDATION_DISABLE("400009","图形验证码失效"),
	
	PICTURE_VALIDATION_ERROR("400010","图形验证验证错误"),
	
	GET_PHONE_VALIDATION_FAIL("400011","短信验证码已发送到您的手机，请1分钟后再试！"),
	
	GETPHONE_VALIDATION_TYPE_ERROR("400012","获取短信的类型有误！"),
	
	PHONE_VALIDATION_DISABLE("400013","您的手机验证码失效，请重新获取手机验证码再试！"),
	
	PHONE_VALIDATION_ERROR("400014","您的手机验证码失效，请重新获取手机验证码再试！"),
	
	AGENT_NOT_BIND_WATCH("400015","您还没有绑定微信,请使用手机号码和密码登录！"),
	
	AGENT_OLD_PASSWORD_ERROR("400016","修改密码失败,原密码错误，请重试！"),
	
	AGENT_UPDATE_PASSWORD_ERROR("400017","修改密码失败,数据更新错误！"),
	
	AGENT_UNBIND_FAIL("400018","你无权解绑该账号，详情请联系客服！"),
	
	AGENT_ACCOUNT_PWD_ERROR("400019","您的密码错误请确认后再试！"),
	
	AGENT_UNBIND_ERROR("400020","解绑失败，请联系客服！"),
	
	AGENT_SIGNOUT_ERROR("400021","修改密码失败,数据更新错误！"),
    /**
     * 410000-419999 building
     */
    BUILDING_ID_IS_NULL("410001", "房源id不能为空"),
    BUILDING_IS_NOT_EXIST("410002", "房源不存在"),
    BUILDING_COLLECTION_IS_EXIST("410003", "房源收藏记录已存在，不能重复收藏"),
    BUILDING_COLLECTION_IS_NOT_EXIST("410004", "房源收藏记录不存在，不能取消收藏"),

    /**
     * 420000-429999 recommend
     */
    RECOMMEND_IS_NOTEXIST("420001", "该报备订单不存在"),

    RECOMMEND_IS_NOAUTHCANCEL("420002", "没有权限操作取消该订单"),
    RECOMMEND_IS_APPROVEEND_CANT_CANCEL("420003", "该订单已通过管理员审核，经纪人无权限取消，取消失败(只有待审核的订单可以取消)"),
    RECOMMEND_IS_CANCELED_CANT_CANCEL("420004", "该订单已取消，请不要重复取消"),
    RECOMMEND_IS_APPROVEEND_CANT_MODIFY("420005", "该订单已通过管理员审核，经纪人无权限修改"),
    RECOMMEND_IS_CANCELED_CANT_MODIFY("420006", "该订单已取消，请不要重复取消"),
    RECOMMEND_IS_APPROVEEND_CANT_SAVERECONFIRMARRIVE("420005", "该订单已未通过管理员审核，暂不支持提交客户预约信息"),
    RECOMMEND_IS_RECONFIRM_CANT_SAVERECONFIRMARRIVE("420005", "该订单已经预约成功。暂不支持修改，若有变更，请联系客服处理"),
    RECOMMENDCOMMISION_IS_NOAUTH("420006", "您无权限查看该佣金信息"),
    
    AGENT_INFO_ERROR("420006", "该代理商不存在，或状态异常"),
    BUILDING_INFO_ERROR("420007", "该楼盘不存在，或状态异常"),
    SYS_USER_INFO_ERROR("420008", "项目经理和驻场配置错误"),
    FAILED("-1", "操作失败");
    private String retCode;
    private String retMsg;

    private ReturnCode(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
