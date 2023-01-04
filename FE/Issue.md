# Issue 

## 0104
### 랜딩 페이지에서 로그인 페이지로 넘어갈 때, 렌더링이 3번 일어나는 현상을 확인하였다.
``` javascript
LandingPage - LandingPage.js
// 컴포넌트가 화면에 다 나타나면 timeout 함수 실행  
  useEffect(() => {  
    timeout();  
    return () => {  
      // clear 해줌  
      clearTimeout(timeout);  
    };  
  });  
```
다음과 같이 수정하였다. 
  
``` javascript
  useEffect(() => {  
    timeout();  
    return () => {  
      // clear 해줌  
      clearTimeout(timeout);  
    };  
  }, []);  

   ```