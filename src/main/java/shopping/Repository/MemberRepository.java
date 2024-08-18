package shopping.Repository;

import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import shopping.Model.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(@Email String email);

    Optional<Member> findByEmailAndPassword(@Email String email, String password);
}