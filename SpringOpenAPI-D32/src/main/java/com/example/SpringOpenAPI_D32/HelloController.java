package com.example.SpringOpenAPI_D32;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @Operation(
            summary = "Say Hello",
            description = "Returns a welcome message to the user"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful response"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @GetMapping
    public String hello() {
        return "Hello from Swagger API";
    }

    @Operation(
            summary = "harry User",
            description = "harry the user using name parameter"
    )
    @GetMapping("/harry")
    public String harryUser(
            @io.swagger.v3.oas.annotations.Parameter(
                    description = "Name of the user",
                    example = "Deeps",
                    required = true
            )
            @RequestParam String name
    ) {
        return "Hello " + name;
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/secure")
    public String secureApi() {
        return "This is a secured API";
    }
}
