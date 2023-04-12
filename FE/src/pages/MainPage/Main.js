import React from "react";
import { Link } from "react-router-dom";
import LeftSeat from "../../components/MainPage/LeftSeat";
import "./Main.css";
function Main() {
  // 남은좌석/ 총좌석 데이터 받아오기 위한 axios
  // axios({
  //   method: "get",
  //   url: `@@@@@@@@@@@@@@@ 남은좌석/ 총좌석 데이터 url @@@@@@@@@@@@@@@`,
  //   headers: {
  //     "Content-Type": "application/json",
  //     Authorization: `Bearer ${myToken}`,
  //   },
  // })
  //   .then((res) => {
  //     console.log(`res.data: ${res.data}`);
  //   })
  //   .catch((err) => console.log(err));
  return (
    <>
      <div className="main">
        <LeftSeat></LeftSeat>
        <div className="MainBtnsDiv">
          {/* 자습실 예약 */}
          <Link to="/reservation/list">
            <div className="SingleResvationDiv">
              <div className="btnDiv">
                <div className="imgDiv"> </div>
                <div>
                  <img id="singleIcon1" src="assets/images/laptop.png"></img>
                </div>
                <span id="btnTitle">자습실 예약</span>
              </div>
            </div>
          </Link>
          {/* 스터디룸 예약 */}
          <Link to="/reservation/list">
            <div className="MultiResvationDiv">
              <div className="btnDiv">
                <div className="imgDiv"> </div>
                <div>
                  <img id="singleIcon2" src="assets/images/group.png"></img>
                </div>
                <span id="btnTitle">스터디룸 예약</span>
              </div>
            </div>{" "}
          </Link>
          {/* 게시판 보기 */}
          <Link to="/community">
            <div className="BoardDiv">
              <div className="btnDiv">
                <div className="imgDiv"> </div>
                <div>
                  <img id="singleIcon3" src="assets/images/board.png"></img>
                </div>
                <span id="btnTitle">게시판 보기</span>
              </div>
            </div>
          </Link>
          {/* 공지사항 */}
          <Link to="/notice">
            <div className="NoticeDiv">
              <div className="btnDiv">
                <div className="imgDiv"> </div>
                <div>
                  <img id="singleIcon4" src="assets/images/bulb.png"></img>
                </div>
                <span id="btnTitle">공지사항</span>
              </div>
            </div>
          </Link>
        </div>
        <div className="SeatDiv">
          <div id="seatDivLabel">좌석 현황 보기</div>
          <Link to="/fastCheck">
            <div id="currentbtnDiv">
              <div id="currentbtnTitle">한 눈에 좌석을 확인해요!</div>
              <div id="currentbtnTitleDesc">10초만에 확인할 수 있습니다.</div>

              <div>
                <img id="ancestors" src="assets/images/ancestors.png" />
              </div>
            </div>
          </Link>
        </div>
      </div>
    </>
  );
}

export default Main;
