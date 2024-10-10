<script>
    import { onMount } from 'svelte';
    import { getAllPaintings } from '$lib/api.js';
    import { goto } from '$app/navigation';
    let paintings = [];
    let searchName = '';

    onMount(async () => {
        try {
            const response = await getAllPaintings();
            console.log(response); // Log the response to inspect its structure
            paintings = response; // Assuming response is an array of paintings
        } catch (error) {
            console.error('Error fetching paintings:', error);
        }
    });

    function handleSearch(event) {
        event.preventDefault();
        const painting = paintings.find(p => p.name.toLowerCase() === searchName.toLowerCase());
        if (painting) {
            goto(`/update/${painting.id}`);
        } else {
            alert('Painting not found');
        }
    }
</script>


<h2 class="text-center text-3xl font-bold" >Update Painting</h2>


<div class="flex flex-col items-center mb-20">
    <div class="flex-grow w-full max-w-2xl mx-auto mt-6">
        <form class="flex w-full rounded bg-white" on:submit={handleSearch}>
            <input bind:value={searchName} class="w-full border-none bg-transparent px-4 py-1 text-gray-400 outline-none focus:outline-none" type="search" name="search" placeholder="Search..." />
            <button type="submit" class="m-2 rounded bg-indigo-700 px-4 py-2 text-white">
                <svg class="fill-current h-6 w-6" xmlns="http://www.w3.org/2000/svg" id="Capa_1" x="0px" y="0px" viewBox="0 0 56.966 56.966" style="enable-background:new 0 0 56.966 56.966;" xml:space="preserve" width="512px" height="512px">
                    <path d="M55.146,51.887L41.588,37.786c3.486-4.144,5.396-9.358,5.396-14.786c0-12.682-10.318-23-23-23s-23,10.318-23,23  s10.318,23,23,23c4.761,0,9.298-1.436,13.177-4.162l13.661,14.208c0.571,0.593,1.339,0.92,2.162,0.92  c0.779,0,1.518-0.297,2.079-0.837C56.255,54.982,56.293,53.08,55.146,51.887z M23.984,6c9.374,0,17,7.626,17,17s-7.626,17-17,17  s-17-7.626-17-17S14.61,6,23.984,6z" />
                </svg>
            </button>
        </form>
        <div class="flex max-w-2xl mx-auto my-6">
            <div class="w-full md:w-1/2 flex flex-col items-center h-64">
                <div class="w-full px-4">
                    <div class="flex flex-col items-center relative">
                        <div class="absolute shadow bg-white top-100 z-40 w-full lef-0 rounded max-h-select overflow-y-auto svelte-5uyqqj">
                            <div class="flex flex-col w-full">
                                {#each paintings as painting}
                                    <a href="/update/{painting.id}">
                                        <div class="cursor-pointer w-full border-gray-100 rounded-t border-b hover:bg-teal-100">
                                            <div class="flex w-full items-center p-2 pl-2 border-transparent border-l-2 relative hover:border-teal-100">
                                                <div class="w-full items-center flex">
                                                    <div class="mx-2 -mt-1">{painting.name}</div>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                {/each}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

