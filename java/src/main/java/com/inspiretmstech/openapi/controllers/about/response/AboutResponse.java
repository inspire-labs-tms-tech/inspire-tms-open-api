package com.inspiretmstech.openapi.controllers.about.response;

public record AboutResponse(String version, AboutCompanyResponse company, AboutSupabaseResponse supabase) {
}
