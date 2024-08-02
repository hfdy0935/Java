import {useState} from 'react';

const App = () => {
    const [num, setNum] = useState<number>(0);
    const onClick = () => {
        setNum(i => i + 1);
    }

    return (
        <div>
            <div>{num}</div>
            <button onClick={onClick}>num + 1</button>
        </div>
    )
}