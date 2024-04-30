package faceweb.demo2.Controller;

import faceweb.demo2.Domain.BoardItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/board")
public class SubController {

    @GetMapping("/index")
    public ResponseEntity<List<BoardItem>> getBoardItems() {
        // 게시판 데이터 목록 생성 (임시 데이터)
        List<BoardItem> boardItems = new ArrayList<>();
        boardItems.add(new BoardItem("게시물 제목 1", "사용자1", "2024-04-22", 100));
        boardItems.add(new BoardItem("게시물 제목 2", "사용자2", "2024-04-23", 150));
        boardItems.add(new BoardItem("게시물 제목 3", "사용자3", "2024-04-24", 120));

        // 데이터 반환
        return new ResponseEntity<>(boardItems, HttpStatus.OK);
    }

    public class pages{
        int start, end;
        public pages(int start, int end){
            this.start=start;
            this.end=end;
        }
    }
    @GetMapping("pageNation")
    public ResponseEntity<pages> getPageNation(){
        return new ResponseEntity<pages>(new pages(1, 5), HttpStatus.OK);
    }
}