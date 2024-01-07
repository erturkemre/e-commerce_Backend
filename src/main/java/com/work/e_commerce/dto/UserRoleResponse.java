package com.work.e_commerce.dto;

import java.util.List;

public record UserRoleResponse(long id, String name, String email, List<RoleResponse> roleResponseList) {
}
