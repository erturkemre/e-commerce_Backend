package com.work.e_commerce.dto;

import com.work.e_commerce.entity.RoleName;

public record RoleResponse(long id, RoleName roleName, String storeName, String storePhone, String storeTaxNum, String iban ) {
}
