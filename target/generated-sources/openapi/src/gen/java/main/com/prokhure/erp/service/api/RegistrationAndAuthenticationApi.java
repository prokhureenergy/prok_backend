/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.prokhure.erp.service.api;

import com.prokhure.erp.service.model.AuthUserResetPasswordRequest;
import com.prokhure.erp.service.model.Authentication;
import com.prokhure.erp.service.model.AuthenticationResponse;
import com.prokhure.erp.service.model.Errors;
import com.prokhure.erp.service.model.ProcessToken;
import com.prokhure.erp.service.model.Registration;
import com.prokhure.erp.service.model.ResetPasswordByEmailRequest;
import com.prokhure.erp.service.model.ResponseDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T15:58:53.899225+01:00[Africa/Lagos]")
@Validated
@Tag(name = "registration and authentication", description = "the registration and authentication API")
public interface RegistrationAndAuthenticationApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /user/registration : Register a new user
     * Register a new user
     *
     * @param registration Create a new user (required)
     * @return Successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or user not found (status code 404)
     *         or Pet not found (status code 403)
     *         or Validation exception (status code 422)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "registerUser",
        summary = "Register a new user",
        description = "Register a new user",
        tags = { "registration and authentication" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "404", description = "user not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "403", description = "Pet not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "422", description = "Validation exception", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user/registration",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ResponseDto> registerUser(
        @Parameter(name = "Registration", description = "Create a new user", required = true) @Valid @RequestBody Registration registration
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : { \"partyId\" : \"123e4567-e89b-12d3-a456-426614174000\", \"message\" : \"we have sent a token to xyz@mail.com\" }, \"description\" : \"successful\", \"status\" : \"00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /user/token : Resend or process token
     * resend or process token
     *
     * @param processToken Reset or process token (required)
     * @return Successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or user not found (status code 404)
     *         or user not found (status code 403)
     *         or Validation exception (status code 422)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "resetOrProcessToken",
        summary = "Resend or process token",
        description = "resend or process token",
        tags = { "registration and authentication" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "404", description = "user not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "403", description = "user not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "422", description = "Validation exception", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user/token",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ResponseDto> resetOrProcessToken(
        @Parameter(name = "ProcessToken", description = "Reset or process token", required = true) @Valid @RequestBody ProcessToken processToken
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : { \"partyId\" : \"123e4567-e89b-12d3-a456-426614174000\", \"message\" : \"we have sent a token to xyz@mail.com\" }, \"description\" : \"successful\", \"status\" : \"00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /user/password/reset : Reset password
     * reset password
     *
     * @param authUserResetPasswordRequest Reset password when use is loggedin (required)
     * @return Successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or user not found (status code 404)
     *         or user not found (status code 403)
     *         or Validation exception (status code 422)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "resetPassword",
        summary = "Reset password",
        description = "reset password",
        tags = { "registration and authentication" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "404", description = "user not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "403", description = "user not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "422", description = "Validation exception", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user/password/reset",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ResponseDto> resetPassword(
        @Parameter(name = "AuthUserResetPasswordRequest", description = "Reset password when use is loggedin", required = true) @Valid @RequestBody AuthUserResetPasswordRequest authUserResetPasswordRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : { \"partyId\" : \"123e4567-e89b-12d3-a456-426614174000\", \"message\" : \"we have sent a token to xyz@mail.com\" }, \"description\" : \"successful\", \"status\" : \"00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /user/password/reset/email : Reset password by email
     * reset password
     *
     * @param resetPasswordByEmailRequest Reset password when user clicks on forget password (required)
     * @return Successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or user not found (status code 404)
     *         or user not found (status code 403)
     *         or Validation exception (status code 422)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "resetPasswordByEmail",
        summary = "Reset password by email",
        description = "reset password",
        tags = { "registration and authentication" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "404", description = "user not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "403", description = "user not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "422", description = "Validation exception", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user/password/reset/email",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ResponseDto> resetPasswordByEmail(
        @Parameter(name = "ResetPasswordByEmailRequest", description = "Reset password when user clicks on forget password", required = true) @Valid @RequestBody ResetPasswordByEmailRequest resetPasswordByEmailRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : { \"partyId\" : \"123e4567-e89b-12d3-a456-426614174000\", \"message\" : \"we have sent a token to xyz@mail.com\" }, \"description\" : \"successful\", \"status\" : \"00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /user/login : User Login
     * user login
     *
     * @param authentication Login supply username password and userType (required)
     * @return Successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or user not found (status code 404)
     *         or user not found (status code 403)
     *         or Validation exception (status code 422)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "userLogin",
        summary = "User Login",
        description = "user login",
        tags = { "registration and authentication" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AuthenticationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "404", description = "user not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "403", description = "user not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "422", description = "Validation exception", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user/login",
        produces = { "application/json" },
        consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" }
    )
    default ResponseEntity<AuthenticationResponse> userLogin(
        @Parameter(name = "Authentication", description = "Login supply username password and userType", required = true) @Valid @RequestBody Authentication authentication
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : { \"userDetail\" : { \"role\" : \"admin\", \"permissions\" : [ \"canEditUser\", \"canAddUser\", \"canViewFinance\" ], \"name\" : \"Mike Joe\", \"userId\" : \"123e4567-e89b-12d3-a456-426614174000\", \"email\" : \"xyz@mail.com\" }, \"tokenDetail\" : { \"expirationTime\" : 0.8008281904610115, \"token\" : \"token\", \"refreshToken\" : \"refreshToken\" } }, \"description\" : \"successful\", \"status\" : \"00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
