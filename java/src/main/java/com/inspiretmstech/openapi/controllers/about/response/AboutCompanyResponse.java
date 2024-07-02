package com.inspiretmstech.openapi.controllers.about.response;

import com.inspiretmstech.db.tables.records.CompaniesRecord;

import java.util.Optional;
import java.util.UUID;

public record AboutCompanyResponse(String name, boolean published, String logo) {

    public static AboutCompanyResponse from(CompaniesRecord company, String origin) {
        Optional<UUID> logoFileID = Optional.ofNullable(company.getLogoFileId());
        String logoURL = logoFileID.map(uuid -> origin + "/api/v1/files/" + uuid.toString()).orElse(null);
        return new AboutCompanyResponse(company.getDisplayName(), company.getIsPublished(), logoURL);
    }

}
