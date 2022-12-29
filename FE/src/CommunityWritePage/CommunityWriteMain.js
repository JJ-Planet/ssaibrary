import React from "react";
import "./CommunityWriteMain.css";
import { Link } from "react-router-dom";

function Main() {
  return (
    <>
      <div className="CommunityWriteMain">
        <form>
          <div className="PostingWritingHeader">
            <input
              className="PostingWritingTitle"
              type="text"
              placeholder="제목을 입력해 주세요."
            ></input>
            <div className="PostingWritingBtnBoxDiv">
              {/* 55.7 */}
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
          <div className="PostingDesc">
            <div className="PDAttachImgDiv">
              <div className="PDAttachImg"></div>
            </div>
            <div className="PDDescTextDiv">
              <textarea
                className="PDDescText"
                type=""
                placeholder="내용을 입력해 주세요."
              ></textarea>
            </div>
            <div className="TagDiv">
              <div className="TagSeperator1"></div>
              <input
                className="TagText"
                type="text"
                placeholder="#태그 입력(#으로 구분, 최대 10자)"
              ></input>
              <div className="TagSeperator2"></div>
            </div>
            <div className="PostingControlBtnDiv">
              <input className="PostingModifyBtn" type="button" value="글 수정"></input>
              <input className="PostingCancleBtn" type="button" value="글 취소"></input>
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
