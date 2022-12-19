import React from "react";
import "./Body.css";
function Body() {
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
        <div className="BtnsDiv">
          {/* 자습실 예약 */}
          <div className="SingleResvationDiv">
            <div className="btnDiv">
              <div className="imgDiv"> </div>
              <div id="singleIcon"></div>
              <span id="btnTitle">자습실 예약</span>
            </div>
          </div>
          {/* 스터디룸 예약 */}
          <div className="MultiResvationDiv">
            <div className="btnDiv">
              <div className="imgDiv"> </div>
              <div id="singleIcon"></div>
              <span id="btnTitle">스터디룸 예약</span>
            </div>
          </div>
          {/* 게시판 보기 */}
          <div className="BoardDiv">
            <div className="btnDiv">
              <div className="imgDiv"> </div>
              <div id="singleIcon"></div>
              <span id="btnTitle">게시판 보기</span>
            </div>
          </div>
          {/* 공지사항 */}
          <div className="NoticeDiv">
            <div className="btnDiv">
              <div className="imgDiv"> </div>
              <div id="singleIcon"></div>
              <span id="btnTitle">공지사항</span>
            </div>
          </div>
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

export default Body;
