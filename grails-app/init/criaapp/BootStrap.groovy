package criaapp

import com.asinha.domain.User
import com.asinha.domain.Role
import com.asinha.domain.UserRole

class BootStrap {

    def customUserDetailsService

    def init = { servletContext ->
        new Role(authority: 'ROLE_ADMIN').save()
        new Role(authority: 'ROLE_USER').save()
    }

    def destroy = {}
    
}
