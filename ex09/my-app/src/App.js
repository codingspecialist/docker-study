import { useState } from 'react';
import './App.css';
import Card from './components/Card';
import { useEffect } from 'react';

function App() {

  const [products, setProducts] = useState([]);

  async function onLoad(){
    let response = await fetch("/api/products");
    let responseBody = await response.json();
    console.log("onLoad", responseBody);
    setProducts(responseBody);
  }

  // 해당 페이지가 열릴 때 한번 실행이됨. (초기화 메서드)
  // 어떤 값이 변경될때? 다시 그림을 그릴꺼야? 빈배열(어떤 값이든)
  useEffect(()=>{
    onLoad();
  }, []);

  return (
    <div>
      <h1>상품목록페이지</h1>
      <hr/>
      <div>
        {products.map((product)=> <Card product={product}/>)}
      </div>
    </div>
  );
}

export default App;
