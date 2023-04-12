import React from "react";
import "./CommunityDetailMain.css";
import { Link, useLocation } from "react-router-dom";

// const pageUpTarget = document.querySelector(".PostingWritingHeader");
// const pageUpBtn = document.querySelector(".FocusCeilingBtnText");
// pageUpBtn.addEventListener("click", () => {
//   window.scrollBy({ top: pageUpTarget.getBoundingClientRect().top, behavior: "smooth" });
// });

function Main() {
  const PostingData = useLocation().state.data;
  return (
    <>
      <div className="CommunityDetailMain">
        <div className="PDHeader">
          <span className="PDTitleText">{PostingData.title}</span>
          <div className="PDInfoDiv">
            <div className="PDProfileImgDiv">
              <div>
                <img
                  className="PDProfileImg"
                  src="assets/images/man2.png"
                ></img>
              </div>
            </div>
            <div className="PDInfoDescDiv">
              <span className="PDNameText">{PostingData.user}</span>
              <span className="PDDateText">2022.12.25</span>
              <span className="PDTimeText">{PostingData.postingTime}</span>
              <div className="PDHitsDiv">
                <span className="PDHitsText">조회</span>
                <span className="PDHitsCnt">{PostingData.hits}</span>
              </div>
            </div>
          </div>
          <div className="PDSeperator1"></div>
        </div>
        <div className="PDDescDiv">
          <div className="PDDescAttachImgDiv">
            <div>
              <img
                className="PDDescAttachImg"
                src="assets/images/youngMan.png"
              ></img>
            </div>
          </div>
          <span className="PDDescText">내용 입력 칸 입니다.</span>
          <div className="PDControlBtnDiv">
            <button className="PDModifyBtn">
              <span className="PDModifyBtnText">글 수정</span>
            </button>
            <button className="PDDeleteBtn">
              <span className="PDDeleteBtnText">글 삭제</span>
            </button>
            <button className="PDListBtn">
              <span className="PDListBtnText">글 목록</span>
            </button>
          </div>
          <div className="PDSeperator2"></div>
          <div className="PDCommentLabelDiv">
            <span className="PDCommentLabelText">댓글</span>
            <span className="PDCommentLabelCnt">{PostingData.commentCnt}</span>
            <div>
              <img
                className="PDCommentArrowImg"
                src="assets/images/arrowRight.png"
              ></img>
            </div>
          </div>
          <div className="PDCommentInfoDiv">
            <div className="PDCommentProfileDiv">
              <div>
                <img
                  className="PDCommentProfileImg"
                  src="assets/images/man2.png"
                ></img>
              </div>
            </div>
            <div className="PDCommentInfoDescDiv">
              <span className="PDCommentNameText">김기린</span>
              <div className="PDCommentNewImg">
                <span className="PDCommentNewText">N</span>
              </div>
              <span className="PDCommentDescText">최고에유~!~!</span>
              <span className="PDCommentDateText">2022.12.25</span>
              <span className="PDCommentTimeText">01:54</span>
              <button className="PDCommentingBtn">답글쓰기</button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Main;
