package dat3.cars.api;

import dat3.cars.dto.MemberRequest;
import dat3.cars.dto.MemberResponse;
import dat3.cars.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    MemberService memberService;

    //Security ???
    @GetMapping
    List<MemberResponse> getMembers(){
        return memberService.findMembers();
    }

    //Security ???
    @GetMapping(path = "/{username}")
    MemberResponse getMemberById(@PathVariable String username) throws Exception {return null;}

    //Security --> ??????
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //@PostMapping // same as above when you are using @RestController
    MemberResponse addMember(@RequestBody MemberRequest body){
        return null;
    }

    //Just to demonstrate that clients can control type of what they get back
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
    String addMember2(@RequestBody MemberRequest body){
        return null;
    }

    //Security USER/ADMIN???
    @PutMapping("/{username}")
    ResponseEntity<Boolean> editMember(@RequestBody MemberRequest body, @PathVariable String username){
        return null;
    }

    //Security ADMIN????
    @PatchMapping("/ranking/{username}/{value}")
    void setRankingForUser(@PathVariable String username, @PathVariable int value) {}

    // Security ????
    @DeleteMapping("/{username}")
    void deleteMemberByUsername(@PathVariable String username) {}

}
