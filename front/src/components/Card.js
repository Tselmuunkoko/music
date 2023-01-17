  export default function Card(props) {
    return (
      // <div key={props.person.email} className="py-4 flex">
      //   <img className="h-10 w-10 rounded-full" src={props.person.image} alt="" />
      //   <div className="ml-3">
      //     <p className="text-sm font-medium text-gray-900">{props.person.name}</p>
      //     <p className="text-sm text-gray-500">{props.person.email}</p>
      //   </div>
      // </div> 
    <div class="flex justify-center">
      <div class="rounded-lg shadow-lg bg-white max-w-sm">
        <div class="p-6">
          <h5 class="text-gray-900 text-xl font-medium mb-2">Card title</h5>
          <p class="text-gray-700 text-base mb-4">
            Some quick example text to build on the card title and make up the bulk of the card's
            content.
          </p>
          <button type="button" class=" inline-block px-6 py-2.5 bg-blue-600 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out">Button</button>
        </div>
      </div>
    </div>
    )
  }