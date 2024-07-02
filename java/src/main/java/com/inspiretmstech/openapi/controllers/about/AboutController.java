package com.inspiretmstech.openapi.controllers.about;

import com.inspiretmstech.db.Tables;
import com.inspiretmstech.db.tables.records.CompaniesRecord;
import com.inspiretmstech.openapi.Runtime;
import com.inspiretmstech.openapi.controllers.Controller;
import com.inspiretmstech.openapi.controllers.about.response.AboutCompanyResponse;
import com.inspiretmstech.openapi.controllers.about.response.AboutResponse;
import com.inspiretmstech.openapi.controllers.about.response.AboutSupabaseKeysResponse;
import com.inspiretmstech.openapi.controllers.about.response.AboutSupabaseResponse;
import com.inspiretmstech.openapi.responses.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController("/about")
public class AboutController extends Controller {

    @Autowired
    private HttpServletRequest request;

    @GetMapping
    public Response<AboutResponse> about() {
        return this.handle((supabase) -> {

            String origin = this.request.getHeader(HttpHeaders.ORIGIN);
            if(Objects.isNull(origin)) throw new Exception("Unable to determine request origin");

            CompaniesRecord company = supabase.selectFrom(Tables.COMPANIES).fetchOne();
            if(Objects.isNull(company)) throw new Exception("Unable to load company");

            return new AboutResponse(
                    Runtime.SEMVER,
                    AboutCompanyResponse.from(company, origin),
                    new AboutSupabaseResponse(Runtime.SUPABASE_CLIENT_SIDE_URL, new AboutSupabaseKeysResponse(Runtime.SUPABASE_ANON_KEY))
            );
        });
    }

}
