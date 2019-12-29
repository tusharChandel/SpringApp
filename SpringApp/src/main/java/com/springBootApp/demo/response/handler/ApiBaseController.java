package com.springBootApp.demo.response.handler;

public class ApiBaseController {

	protected ApiResponse response(String status, Object message) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage(message);
		apiResponse.setStatus(status);
		return apiResponse;
	}

	protected ApiListResponse response(String status, String message, Object code) {
		ApiListResponse apiListResponse = new ApiListResponse();
		apiListResponse.setMessage(message);
		apiListResponse.setStatus(status);
		apiListResponse.setCode(code);
		return apiListResponse;
	}

}
