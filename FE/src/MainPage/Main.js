import React from "react";
import { Link } from "react-router-dom";
import "./Main.css";
function Main() {
  return (
    <>
      <div className="main">
        <div className="SeatCounter">
          <div className="SeatCountDiv">
            <span id="spareSeatLabel">남은 좌석</span>
            <span id="spareSeatCnt">76</span>
            <span id="allSeatLabel">총 좌석</span>
            <span id="allSeatCnt">240</span>
            <div className="Contour"> </div>
          </div>
        </div>
        <div className="MainBtnsDiv">
          {/* 자습실 예약 */}
          <Link to="/reservation/list">
            <div className="SingleResvationDiv">
              <div className="btnDiv">
                <div className="imgDiv"> </div>
                <div id="singleIcon1"></div>
                <span id="btnTitle">자습실 예약</span>
              </div>
            </div>
          </Link>
          {/* 스터디룸 예약 */}
          <Link to="/reservation/list">
            <div className="MultiResvationDiv">
              <div className="btnDiv">
                <div className="imgDiv"> </div>
                <div id="singleIcon2"></div>
                <span id="btnTitle">스터디룸 예약</span>
              </div>
            </div>{" "}
          </Link>
          {/* 게시판 보기 */}
          <Link to="/community">
            <div className="BoardDiv">
              <div className="btnDiv">
                <div className="imgDiv"> </div>
                <div id="singleIcon3"></div>
                <span id="btnTitle">게시판 보기</span>
              </div>
            </div>
          </Link>
          {/* 공지사항 */}
          <Link to="/notice">
            <div className="NoticeDiv">
              <div className="btnDiv">
                <div className="imgDiv"> </div>
                <div id="singleIcon4"></div>
                <span id="btnTitle">공지사항</span>
              </div>
            </div>
          </Link>
        </div>
        <div className="SeatDiv">
          <div id="seatDivLabel">좌석 현황 보기</div>
          <div id="currentbtnDiv">
            <div id="currentbtnTitle">한 눈에 좌석을 확인해요!</div>
            <div id="currentbtnTitleDesc">10초만에 확인할 수 있습니다.</div>

            <div id="ancestors"></div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Main;
