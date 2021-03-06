package org.serendipity.webbff.model;

import lombok.Data;

@Data
public class TokenResponse {

  private Integer expires_in;

  private String access_token;
  private String id_token;
  private String refresh_token;
  private String scope;
  private String token_type;

}

// https://projectlombok.org/features/Data

/*

{
    "access_token": "eyJraWQiOiJ0MG1vUzFQY2FrNDVDRXkzREgxWjkwbVdQNEhvN3pZN3dOV3FDLU5lWG1BIiwiYWxnIjoiUlMyNTYifQ.eyJpYXQiOjE2MTgzNzI4NTYsImV4cCI6MTYxODM3Mjk3NiwibmJmIjoxNjE4MzcyODU1LCJzdWIiOiJhNWUwMmI5Ni0yNjRmLTQ1ZGItODZjOS1hOTI0ZjQ2YWFiNDciLCJqdGkiOiJhOTJkNzVkNS1lYjJmLTRjMWEtYmE5MS1lMzgwODU5ZjNiNWYiLCJycGkiOiI0Y2VkM2I3OS1mODAwLTQyYTMtOWY2ZS1kMzg4ZTUyNDhhMDgiLCJpc3MiOiJodHRwczovL29uYi5hdXRoLmlkZW50aXR5Lmdvdi5hdSJ9.Egj6TsmrSwlAId0y9htlphotNhJKru6efVIprSnTYlsQLsLN39mPjq3bF2C8x8eoRsm6txRYPGsJe9iYM_LQ7leC8B1e5CnI6Mdlal5hM984YXNJgCIhod-bNpQXso3JebpqrwldhXTx0XGBawDDoYZrzzami8jTW2J0rhiLvfJ2aKD7tigOyR6vwc1HGGjDFYCwO8LauuUADXC9K_FiO-BAeh6g2q0HWBS5OEgiqu5Kb6_6ZcRkXV2bOt642GvbWvGVtFGB9OAbOruYFWnpAPiD26ET0BhuRw13iGkGoIuV0UsKun5L3CimaRJEVwIpv7-s9lFnUmkSusDuFS0vqA",
    "scope": "openid profile",
    "id_token": "eyJ4NXQiOiJaVFE0TVRVNVpqVmxOMkUxTVRaa09UWmtPVE5qWlRJNE1XVXdOVFJqTTJFellXTXlZekUxTWciLCJraWQiOiJ0MG1vUzFQY2FrNDVDRXkzREgxWjkwbVdQNEhvN3pZN3dOV3FDLU5lWG1BIiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiIyOGVkNTUzZi04ZjNhLTQ4MmItYWYyMS1mYmZmYmRiMTBiY2EiLCJhY3IiOiJ1cm46aWQuZ292LmF1OnRkaWY6YWNyOmlwMjpjbDIiLCJiaXJ0aGRhdGUiOiIxOTgwLTAxLTAxIiwiYXV0aF90aW1lIjoxNjE4MzcyNTQwLCJ0ZGlmX2F1ZGl0X2lkIjoiNGNlZDNiNzktZjgwMC00MmEzLTlmNmUtZDM4OGU1MjQ4YTA4IiwidGRpZl9jb3JlX3VwZGF0ZWRfYXQiOiIxNjE0NjU0NzUxIiwicnBfYXVkaXRfaWQiOiI0Y2VkM2I3OS1mODAwLTQyYTMtOWY2ZS1kMzg4ZTUyNDhhMDgiLCJnaXZlbl9uYW1lIjoiUm9iZXJ0IiwiZmFtaWx5X25hbWUiOiJGZXJndXNvbiIsImV4cCI6MTYxODM3NjQ1NiwibmJmIjoxNjE4MzcyNTU2LCJqdGkiOiIyNGEzOTI4ZC0zZTViLTRlM2ItYmJlNy03NjQ1OTEzY2ZlMjYiLCJub25jZSI6IjU2ZDllMmU2LTcwOWEtNGUyYi05MTUzLTQ4NzNkNzdhYzQzZSIsImlhdCI6MTYxODM3Mjg1NiwiaXNzIjoiaHR0cHM6Ly9vbmIuYXV0aC5pZGVudGl0eS5nb3YuYXUiLCJhdF9oYXNoIjoiNXRjeDBzdi1QOHk2MklmcnpTYmtvdyIsImF1ZCI6ImdvdnBhc3MtcnAtZHRhLXRlc3QtZjZlOWQ4OGYtYjgzMiJ9.ah-oR06GuL662ZCuGzbasFlylztBKHoyyWVlnx5fxE7lte2tk5aAal8dUoHIyuXh2I1A1etOGte5CF5RNqOl_SM-R2AQ4FeubMzaAdl0BbNiPCG8Hd5y8Pu4LKY8f9pDNcf84NRYCB-OKR--x9oCV8_rNXQg7kBEr5MUAf7wj0l8Ag3WG053h_oLQQmdhPN_HHrA4274KN1g3oiCnA1j3xmsCi6SNKptZHzP8BJXtg7GyfP42qiYmGeZnDWMzwDhi2u2cBoxIAn3kEh-MQHsf9N7t1j9ewaUT5RCTXDDR7FtJwTwHCk_Po_XQ-3C-C15_gdjf7QUzRKZ5uXHXOl-WA",
    "token_type": "bearer",
    "expires_in": 3599
}
*/
