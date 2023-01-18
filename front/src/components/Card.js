  export default function Card(props) {
    return (
      // <div key={props.person.email} className="py-4 flex">
      //   <img className="h-10 w-10 rounded-full" src={props.person.image} alt="" />
      //   <div className="ml-3">
      //     <p className="text-sm font-medium text-gray-900">{props.person.name}</p>
      //     <p className="text-sm text-gray-500">{props.person.email}</p>
      //   </div>
      // </div> 
    <div class="shrink-0 flex justify-center w-60 mr-4 h-50">
      <div class="rounded-lg shadow-lg bg-white">
        <div class="p-6">
          <h5 class="text-gray-900 text-xl font-medium mb-2">{props.result.title}</h5>
          <p class="text-gray-700 text-base mb-4">
            {props.result.subtitle}
          </p>
          <a type="button" href={props.result.url} class="inline-block px-6 py-2.5 text-blue font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out">Go to music</a>
        </div>
      </div>
    </div>
    )
  }