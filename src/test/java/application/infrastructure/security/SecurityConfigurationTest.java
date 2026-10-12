package application.infrastructure.security;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class SecurityConfigurationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    void h2ConsoleShouldBeAccessibleForLocalDevelopment() throws Exception {
        mockMvc.perform(get("/h2-console/"))
                .andExpect(status().isOk());
    }

    @Test
    void apiRequiresAuthentication() throws Exception {
        mockMvc.perform(get("/api/catalog"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void administratorCanReadCatalog() throws Exception {
        mockMvc.perform(get("/api/catalog")
                .with(httpBasic("marker-admin", "marker-dev-password")))
                .andExpect(status().isOk());
    }

    @Test
    void administratorCannotUseBuyerCartEndpoint() throws Exception {
        mockMvc.perform(get("/api/carts")
                .with(httpBasic("marker-admin", "marker-dev-password")))
                .andExpect(status().isForbidden());
    }
    @Test
    void buyerCannotReadUnpublishedProductManagementEndpoint() throws Exception {
        mockMvc.perform(get("/api/products")
                .with(httpBasic("marker-buyer", "marker-dev-password")))
                .andExpect(status().isForbidden());
    }

}
