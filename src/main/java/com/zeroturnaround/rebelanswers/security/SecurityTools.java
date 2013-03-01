package com.zeroturnaround.rebelanswers.security;

import com.zeroturnaround.rebelanswers.domain.User;
import com.zeroturnaround.rebelanswers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityTools {

  private final UserService service;

  @Autowired
  public SecurityTools(final UserService service) {
    this.service = service;
  }

  public User getAuthenticatedUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      if (service != null) {
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetailsWrapper) {
          return service.findByUsername(((UserDetailsWrapper) principal).getUsername());
        }
      }
    }

    return null;
  }
}