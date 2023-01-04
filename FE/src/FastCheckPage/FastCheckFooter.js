import React , {useEffect}from "react";
import "./FastCheckFooter.css";
import { Link } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import  { first, second, third } from "../Store/counterFloor"

function Footer() {
  const floor = useSelector((state) => state.counter.value)
  const dispatch = useDispatch()
  // console.log(floor)

  // useEffect(() => {
  //   console.log(floor + "바뀜");
  // });

  return (
    <>
      <div className="bottomBar">
        <Link to="/login">
          <div className="homeBtn">
            <div className="home"></div>
            <div className="homeTitle">Back</div>
          </div>
        </Link>
        {/* <Link to="/account/reservation"> */}
          <div className="reservationBtn" onClick={()=>dispatch(first())}>
            <div className="reservation"></div>
            <div className="reservationTitle">1층</div>
          </div>
        {/* </Link> */}
        {/* <Link to="/community"> */}
          <div className="communityBtn" onClick={()=>dispatch(second())}>
            <div className="community"></div>
            <div className="communityTitle">2층</div>
          </div>
        {/* </Link> */}
        {/* <Link to="/account"> */}
          <div className="accountBtn" onClick={()=>dispatch(third() )}>
            <div className="account"></div>
            <div className="accountTitle">3층</div>
          </div>
        {/* </Link> */}
        <div className="bottomBarDiv"> </div>
      </div>
    </>
  );
}

export default Footer;
