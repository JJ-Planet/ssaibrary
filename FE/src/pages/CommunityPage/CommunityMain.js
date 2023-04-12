import React from "react";
import { Link } from "react-router-dom";
import "./CommunityMain.css";

const DataInfo = [
  {
    id: 1,
    title: "다들 오늘 추우니까 조심하세요!!",
    user: "NickNameTest",
    userImg: "",
    postingTime: "01:54",
    hits: 3,
    commentCnt: 2,
  },
  {
    id: 2,
    title: "다들 오늘 추우니까 조심하세요!!",
    user: "NickNameTest",
    userImg: "",
    postingTime: "01:54",
    hits: 3,
    commentCnt: 2,
  },
  {
    id: 3,
    title: "다들 오늘 추우니까 조심하세요!!",
    user: "NickNameTest",
    userImg: "",
    postingTime: "01:54",
    hits: 3,
    commentCnt: 2,
  },
  {
    id: 4,
    title: "다들 오늘 추우니까 조심하세요!!",
    user: "NickNameTest",
    userImg: "",
    postingTime: "01:54",
    hits: 3,
    commentCnt: 2,
  },
  {
    id: 5,
    title: "다들 오늘 추우니까 조심하세요!!",
    user: "NickNameTest",
    userImg: "",
    postingTime: "01:54",
    hits: 3,
    commentCnt: 2,
  },
  {
    id: 6,
    title: "다들 오늘 추우니까 조심하세요!!",
    user: "NickNameTest",
    userImg: "",
    postingTime: "01:54",
    hits: 3,
    commentCnt: 2,
  },
];

const rendering = () => {
  const result = [];
  for (let i = 0; i < DataInfo.length; i++) {
    result.push(
      <div className="PostingDiv" key={DataInfo[i].id}>
        <Link to={`/community/detail/${DataInfo[i].id}`} state={{ data: DataInfo[i] }}>
          <div className="PostingDivTemp">
            <span className="PostingTitle">{DataInfo[i].title}</span>
            <div className="PostingSubDiv">
              <span className="PostingUserTitle">{DataInfo[i].user}</span>
              <span className="PostingTimeTitle">{DataInfo[i].postingTime}</span>
              <div className="HitsDiv">
                <span className="HitsTitle">조회</span>
                <span className="HitsCnt">{DataInfo[i].hits}</span>
              </div>
            </div>
            <div className="AttachImgDiv">
              <div >
                <img className="AttachImg" src = "assets/images/youngMan.png"/>
              </div>
            </div>
            <div className="CommentDiv">
            <div >
                <img className="CommentImg" src = "assets/images/Balloon.png"/>
              </div>
              <span className="CommentCnt">{DataInfo[i].commentCnt}</span>
            </div>
          </div>
        </Link>
      </div>
    );
  }
  return result;
};

function Main() {
  return (
    <>
      <div className="MainDiv">
        <div className="MenuBarDiv">
          <div className="MenuBarAllBtn">
            <span className="MenuBarAllBtnTitle">전체</span>
          </div>
          <div className="MenuBarPopularBtn">
            <span className="MenuBarPopularBtnTitle">인기</span>
          </div>
          <div className="MenuBarFavoriteBtn">
            <span className="MenuBarFavoriteBtnTitle">즐겨 찾기</span>
          </div>
        </div>
        <Link to="/community/write">
          <div className="WriteBtn">
            <span className="WriteBtnTitle">글 쓰기</span>
          </div>
        </Link>
        <div className="CommunityDummyDiv">{rendering()}</div>
      </div>
    </>
  );
}

export default Main;
