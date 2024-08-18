package shopping.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shopping.Model.Member;
import shopping.Service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/register")
    public String register(@RequestBody Member member, HttpServletRequest request) {

        try {
            Member member1 = memberService.registerMember(member);
            HttpSession session = request.getSession();
            session.setAttribute("loginMember", member1);
            return session.getId();
        } catch (Exception e) {
            return e.getMessage();
        }
    }



}
