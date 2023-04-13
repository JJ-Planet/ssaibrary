import React, { useCallback, useEffect, useState } from "react";
import "./SignUpMain.css";
import { Link, useNavigate } from "react-router-dom";
import Swal from "sweetalert2";
import axios from "axios";

function alertInputClear() {
  Swal.fire({
    text: "작성한 내용을 초기화했습니다.",
    confirmButtonColor: "rgba(51, 28, 158, 0.74);",
    confirmButtonText: "　확인　",
    width: 300,
    backdrop: `rgba(0,0,0,0.4)`,
    allowEnterKey: true,
    icon: "success",
  });
}

function Main() {
  const navigate = useNavigate();

  // each value useState
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [nickName, setNickName] = useState("");
  const [pw, setPw] = useState("");
  const [pwChk, setPwChk] = useState("");
  // Message useState
  const [idMessage, setIdMessage] = useState("");
  const [nameMessage, setNameMessage] = useState("");
  const [nickNameMessage, setNickNameMessage] = useState("");
  const [pwMessage, setPwMessage] = useState("");
  const [pwChkMessage, setPwChkMessage] = useState("");

  // validation check useState
  const [isId, setIsId] = useState(false);
  const [isName, setIsName] = useState(false);
  const [isNickName, setIsNickName] = useState(false);
  const [isPw, setIsPw] = useState(false);
  const [isPwChk, setIsPwChk] = useState(false);
  const [showPw, setShowPw] = useState(false);
  const [showPwChk, setShowPwChk] = useState(false);
  const [checkingAllCB, setCheckingAllCB] = useState(false);

  const API_URL = `http://localhost:8080`;

  // onChange
  const onChangeId = useCallback(
    (e) => {
      setId(e.target.value);
      if (e.target.value.length < 2 || e.target.value.length > 15) {
        setIdMessage("2글자 이상 15글자 이하로 입력해주세요.");
        setIsId(false);
      } else {
        setIdMessage("올바른 ID입니다.");
        setIsId(true);
      }
    },
    [id]
  );

  const onChangeName = useCallback(
    (e) => {
      setName(e.target.value);
      if (e.target.value.length < 2 || e.target.value.length > 5) {
        setNameMessage("2글자 이상 5글자 미만으로 입력해주세요.");
        setIsName(false);
      } else {
        setNameMessage("올바른 이름입니다.");
        setIsName(true);
      }
    },
    [name]
  );
  const onChangeNickName = useCallback(
    (e) => {
      setNickName(e.target.value);
      if (e.target.value.length < 2 || e.target.value.length > 5) {
        setNickNameMessage("2글자 이상 5글자 미만으로 입력해주세요.");
        setIsNickName(false);
      } else {
        setNickNameMessage("올바른 닉네임입니다.");
        setIsNickName(true);
      }
    },
    [nickName]
  );
  const onChangePw = useCallback(
    (e) => {
      setPw(e.target.value);
      if (e.target.value.length < 2 || e.target.value.length > 5) {
        setPwMessage("2글자 이상 5글자 미만으로 입력해주세요.");
        setIsPw(false);
      } else {
        setPwMessage("올바른 비밀번호입니다.");
        setIsPw(true);
      }
    },
    [pw]
  );
  const onChangePwChk = useCallback(
    (e) => {
      setPwChk(e.target.value);
      if (e.target.value !== pw) {
        setPwChkMessage("비밀번호가 일치하지 않습니다.");
        setIsPwChk(false);
      } else {
        setPwChkMessage("비밀번호가 일치합니다.");
        setIsPwChk(true);
      }
    },
    [pwChk]
  );
  // const onChangeCheckingAllCB = useCallback(
  //   (e) => {
  //     const checkBoxes = document.querySelectorAll(".SUAcceptCB");
  //     checkBoxes.forEach((cb) => {
  //       if (checkingAllCB) {
  //         cb.checked = false;
  //       } else {
  //         cb.checked = true;
  //       }
  //     });
  //   },
  //   [checkingAllCB]
  // );

  // onClick
  const toggleShowPw = () => {
    setShowPw(!showPw);
  };
  const toggleShowPwChk = () => {
    setShowPwChk(!showPwChk);
  };
  const toggleCheckingCB = () => {
    setCheckingAllCB(!checkingAllCB);
  };
  const SUInputClear = () => {
    setId("");
    setName("");
    setNickName("");
    setPw("");
    setPwChk("");
    alertInputClear();
    // const checkBoxes = document.querySelectorAll(".SUAcceptCB");
    // checkBoxes.forEach((cb) => {
    //   cb.checked = false;
    // });
  };
  const SUProcessing = () => {
    // - 모든 인풋 유효성검사 + 인증하기 + 필수 동의 3개 됐을 시 넘어감
    // const isCheckedCB2 = document.querySelector(".CB2").checked;
    // const isCheckedCB3 = document.querySelector(".CB3").checked;
    // const isCheckedCB4 = document.querySelector(".CB4").checked;

    // 회원가입 axios: 모든 분기 통과했을 때
    if (isId && isName && isNickName && isPw && isPwChk) {
      console.log(id, name, nickName, pw);
      axios({
        method: "post",
        url: `${API_URL}/member`,
        // headers: {
        //   "Content-Type": "application/json",
        //   Authorization: `Bearer ${myToken}`,
        // },
        data: {
          id: id,
          isAdmin: "",
          joinDate: "",
          name: name,
          nickname: nickName,
          originImage: "",
          password: pw,
          saveImage: "",
          status: "",
        },
      })
        .then((res) => {
          console.log(`res.data: ${res.data}`);
          console.log("회원가입이 완료되었습니다.");
        })
        .catch((err) => console.log(err));

      // signUpDone();
    } else {
      if (!isId) {
        alertIdError();
        console.log("아이디를 확인해주세요.");
      } else if (!isName) {
        alertNameError();
        console.log("이름을 확인해주세요.");
      } else if (!isNickName) {
        alertNickNameError();
        console.log("닉네임을 확인해주세요.");
      } else if (!isPw) {
        alertPwError();
        console.log("비밀번호를 확인해주세요.");
      } else if (!isPwChk) {
        alertPwChkError();
        console.log("비밀번호 확인을 다시해주세요.");
      }
    }

    //
    function signUpDone() {
      Swal.fire({
        text: "회원가입이 완료되었습니다:)",
        confirmButtonColor: "rgba(51, 28, 158, 0.74);",
        confirmButtonText: "　확인　",
        icon: "success",
        width: 300,
        backdrop: `rgba(0,0,0,0.4)`,
        allowEnterKey: true,
      }).then((result) => {
        navigate("/login");
      });
    }
    function alertIdError() {
      Swal.fire({
        text: "아이디를 확인해주세요!",
        confirmButtonColor: "rgba(51, 28, 158, 0.74);",
        confirmButtonText: "　확인　",
        width: 300,
        backdrop: `rgba(0,0,0,0.4)`,
        allowEnterKey: true,
        icon: "error",
      });
    }
    function alertNameError() {
      Swal.fire({
        text: "이름을 확인해주세요!",
        confirmButtonColor: "rgba(51, 28, 158, 0.74);",
        confirmButtonText: "　확인　",
        width: 300,
        backdrop: `rgba(0,0,0,0.4)`,
        allowEnterKey: true,
        icon: "error",
      });
    }
    function alertNickNameError() {
      Swal.fire({
        text: "닉네임을 확인해주세요!",
        confirmButtonColor: "rgba(51, 28, 158, 0.74);",
        confirmButtonText: "　확인　",
        width: 300,
        backdrop: `rgba(0,0,0,0.4)`,
        allowEnterKey: true,
        icon: "error",
      });
    }
    function alertPwError() {
      Swal.fire({
        text: "비밀번호를 확인해주세요!",
        confirmButtonColor: "rgba(51, 28, 158, 0.74);",
        confirmButtonText: "　확인　",
        width: 300,
        backdrop: `rgba(0,0,0,0.4)`,
        allowEnterKey: true,
        icon: "error",
      });
    }
    function alertPwChkError() {
      Swal.fire({
        text: "비밀번호확인을 다시해주세요!",
        confirmButtonColor: "rgba(51, 28, 158, 0.74);",
        confirmButtonText: "　확인　",
        width: 300,
        backdrop: `rgba(0,0,0,0.4)`,
        allowEnterKey: true,
        icon: "error",
      });
    }
    // function alertTermsOfUseError() {
    //   Swal.fire({
    //     text: "필수 이용약관을 모두 동의해주세요!",
    //     confirmButtonColor: "rgba(51, 28, 158, 0.74);",
    //     confirmButtonText: "　확인　",
    //     width: 300,
    //     backdrop: `rgba(0,0,0,0.4)`,
    //     allowEnterKey: true,
    //     icon: "error",
    //   });
    // }
  };

  return (
    <>
      <div className="SUMain">
        <div className="SUHeader">
          <Link to="/login">
            <span className="SUBackBtn">뒤로</span>
          </Link>
          <span className="SUMainTitle">만나서 반가워요!!😄</span>
          <span className="SUSubTitle">
            예약을 쉽게! 간편하게 ! <br></br>
            안녕하세요 SSaibrary 입니다.
          </span>
        </div>
        <div className="SUInputsDiv">
          <form>
            <div className="SUIDDiv">
              <span className="SUIDLabel">ID</span>

              <input className="SUIDInput" type="text" placeholder="ex) 010-1234-5678" onChange={onChangeId} value={id}></input>
              {id.length > 0 && <span className={`SUValiText ${isId ? "Success" : "Fail"}`}>{idMessage}</span>}
            </div>
            <div className="SUNameDiv">
              <span className="SUNameLabel">Name</span>
              <input className="SUNameInput" type="text" placeholder="ex) 홍길동" onChange={onChangeName} value={name}></input>
              {name.length > 0 && <span className={`SUValiText ${isName ? "Success" : "Fail"}`}>{nameMessage}</span>}
            </div>
            <div className="SUNickNameDiv">
              <span className="SUNickLabel">Nick Name</span>
              <input className="SUNickInput" type="text" placeholder="ex) 김기린" onChange={onChangeNickName} value={nickName}></input>
              {nickName.length > 0 && <span className={`SUValiText ${isNickName ? "Success" : "Fail"}`}>{nickNameMessage}</span>}
            </div>
            <div className="SUPWDiv">
              <div onClick={toggleShowPw}>
                <img className={showPw ? "SUPWView" : "SUPWHidden"} src={showPw ? "assets/images/view.png" : "assets/images/hidden.png"} />
              </div>
              <span className="SUPWLabel">Password</span>
              <input className="SUPWInput" type={showPw ? "text" : "password"} placeholder="비밀번호를 입력해 주세요 :)" onChange={onChangePw} value={pw}></input>
              {pw.length > 0 && <span className={`SUValiText ${isPw ? "Success" : "Fail"}`}>{pwMessage}</span>}
            </div>
            <div className="SUPWChkDiv">
              <div onClick={toggleShowPwChk}>
                <img className={showPwChk ? "SUPWView" : "SUPWHidden"} src={showPwChk ? "assets/images/view.png" : "assets/images/hidden.png"} />
              </div>
              <span className="SUPWChkLabel">Password Check</span>
              <input className="SUPWChkInput" type={showPwChk ? "text" : "password"} placeholder="한번 더 똑같이 적어주세요." onChange={onChangePwChk} value={pwChk}></input>
              {pw.length > 0 && pwChk.length > 0 && <span className={`SUValiText ${isPwChk ? "Success" : "Fail"}`}>{pwChkMessage}</span>}
            </div>
          </form>
          <div className="SUBtnDivs">
            <div className="SUReigsterBtnDiv" onClick={SUProcessing}>
              <span className="SingUpBtnText">회원 가입</span>
              <div className="SingUpBtn"></div>
            </div>
            <div className="SUInitBtnDiv" onClick={SUInputClear}>
              <span className="SUClearBtnDivText">초기화</span>
              <div className="SUClearBtn"></div>
            </div>
          </div>
        </div>
        <div className="SUFooter">
          <span className="SUFooterTitle">
            Copy Right <br></br>
            <a href="https://github.com/JJ-Planet" className="SUFooterA">
              ©JJ Planet All Rights Reserved
            </a>
          </span>
        </div>
      </div>
    </>
  );
}

export default Main;
