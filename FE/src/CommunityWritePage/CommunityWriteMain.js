import React from "react";
import "./CommunityWriteMain.css";
import { Link } from "react-router-dom";

const pageUpTarget = document.querySelector(".PostingWritingHeader");
const pageUpBtn = document.querySelector(".FocusCeilingBtnText");
// pageUpBtn.addEventListener("click", () => {
//   window.scrollBy({ top: pageUpTarget.getBoundingClientRect().top, behavior: "smooth" });
// });

function Main() {
  return (
    <>
      <div className="CommunityWriteMain">
        <form>
          <div className="PWHeader">
            <input className="PWTitleText" type="text" placeholder="제목을 입력해 주세요."></input>
            <div className="PWBtnBoxDiv">
              <div className="PWSeperator1"></div>
              <div className="PWSeperator2"></div>
              <div className="BtnDiv1">
                <div className="PhotoBtn"></div>
              </div>
              <div className="BtnDiv2">
                <div className="VideoBtn"></div>
              </div>
              <div className="BtnDiv3">
                <div className="TextBtn"></div>
              </div>
              <div className="BtnDiv4">
                <div className="DdaomBtn"></div>
              </div>
              <div className="BtnDiv5">
                <div className="ImotionBtn"></div>
              </div>
              <div className="BtnDiv6">
                <div className="AddFileBtn"></div>
              </div>
              <div className="BtnDiv7">
                <div className="LocationBtn"></div>
              </div>
            </div>
          </div>
          <div className="PWDescDiv">
            <div className="PWDescAttachImgDiv">
              <div className="PWDescAttachImg"></div>
            </div>
            <div className="PWDescTextDiv">
              <textarea
                className="PWDescText"
                type=""
                placeholder="내용을 입력해 주세요."
              ></textarea>
            </div>
            <div className="PWTagDiv">
              <div className="PWSeperator3"></div>
              <input
                className="PWTagText"
                type="text"
                placeholder="#태그 입력(#으로 구분, 최대 10자)"
              ></input>
              <div className="PWSeperator4"></div>
            </div>
            <div className="PWControlBtnDiv">
              <input className="PWModifyBtn" type="button" value="글 수정"></input>
              <Link to="/community">
                <input className="PWCancleBtn" type="button" value="글 취소"></input>
              </Link>
            </div>
            <div className="FocusCeilingBtnDiv">
              <div className="FocusCeilingBtnImg"></div>
              <span className="FocusCeilingBtnText">맨 위로</span>
            </div>
          </div>
        </form>
      </div>
    </>
  );
}

export default Main;
