package java100.app.web.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java100.app.domain.Score;
import java100.app.service.ScoreService;


@RestController
@RequestMapping("/score")
public class ScoreController {
    
    @Autowired ScoreService scoreService;
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] names,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align) throws Exception {
        
        // UI 제어와 관련된 코드는 이렇게 페이지 컨트롤러에 두어야 한다.
        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }
        HashMap<String,Object> options = new HashMap<>();
        options.put("words",names);
        options.put("orderColumn",orderColumn);
        options.put("align",align);
        
        int totalCount = scoreService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        // Client에게 보낼 데이터를 담을 Map 객체를 준비한다.
        HashMap<String,Object> result = new HashMap<>();
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("list", scoreService.list(pageNo, pageSize, options));
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return result;
        
    }

    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("data", scoreService.get(no));
        
        return result;
    }

    @RequestMapping("form")
    public String form() throws Exception {
        return "score/form";
    }
    
    @RequestMapping("add")
    public Object add(Score score) throws Exception {
        
        scoreService.add(score);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status",  "success");

        return result;
    }

    @RequestMapping("update")
    public Object update(Score score) throws Exception {
        
        scoreService.update(score);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status",  "success");

        return result;
    }

    
    @RequestMapping("delete")
    public Object delete(int no) throws Exception {
        
        scoreService.delete(no);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status",  "success");

        return result;
    }
    

    
}
