<script>
    import '../styles/main.css'
    import '../styles/layout.css'
</script>

<html >
    <body class="bg-indigo-100">
        <header class="bg-indigo-100">
            <!-- component -->
            <header class="bg-gray-800">
                <nav class="container mx-auto px-6 py-3">
                    <div class="flex items-center justify-between">
                        <div class="text-white font-bold text-xl">
                            <a href="/">My Gallery App</a>
                        </div>
                        <div class="hidden md:block">
                            <ul class="flex items-center space-x-8">
                                <li><a href="/" class="text-white">Home</a></li>
                                <li><a href="/get" class="text-white">Get</a></li>
                                <li><a href="/post" class="text-white">Post</a></li>
                                <li><a href="/delete" class="text-white">Delete</a></li>
                                <li><a href="/update" class="text-white">Update</a></li>
                            </ul>
                        </div>
                        <div class="md:hidden">
                            <button class="outline-none mobile-menu-button">
                                <svg class="w-6 h-6 text-white" x-show="!showMenu" fill="none" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" stroke="currentColor">
                                    <path d="M4 6h16M4 12h16M4 18h16"></path>
                                </svg>
                            </button>
                        </div>
                    </div>
                    <div class="mobile-menu hidden md:hidden">
                        <ul class="mt-4 space-y-4">
                            <li><a href="#" class="block px-4 py-2 text-white bg-gray-900 rounded">Home</a></li>
                            <li><a href="#" class="block px-4 py-2 text-white bg-gray-900 rounded">About</a></li>
                            <li><a href="#" class="block px-4 py-2 text-white bg-gray-900 rounded">Services</a></li>
                            <li><a href="#" class="block px-4 py-2 text-white bg-gray-900 rounded">Contact</a></li>
                        </ul>
                    </div>

                </nav>
            </header>
        </header>
        <div class="grid-container">
            <main class="main-content">
                <slot></slot>
            </main>

            <!-- component -->
            <link rel="stylesheet" href="https://demos.creative-tim.com/notus-js/assets/styles/tailwind.css">
            <link rel="stylesheet" href="https://demos.creative-tim.com/notus-js/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">

            <!-- component -->
            <div class="footer w-full max-w-2xl mx-auto my-6">
                <footer class="p-4 bg-white rounded-lg shadow md:px-6 md:py-8 dark:bg-gray-800">
                    <div class="sm:flex sm:items-center sm:justify-between">
                        <ul class="flex flex-wrap items-center mb-6 sm:mb-0">
                            <li><a href="#" class="mr-4 text-sm text-gray-500 hover:underline md:mr-6 dark:text-gray-400">About</a></li>
                            <li><a href="#" class="mr-4 text-sm text-gray-500 hover:underline md:mr-6 dark:text-gray-400">Privacy Policy</a></li>
                            <li><a href="#" class="mr-4 text-sm text-gray-500 hover:underline md:mr-6 dark:text-gray-400">Licensing</a></li>
                            <li><a href="#" class="text-sm text-gray-500 hover:underline dark:text-gray-400">Contact</a></li>
                        </ul>
                    </div>
                    <hr class="my-6 border-gray-200 sm:mx-auto dark:border-gray-700 lg:my-8" />
                    <span class="block text-sm text-gray-500 sm:text-center dark:text-gray-400">© 2024 <a href="/" target="_blank" class="hover:underline">My Gallery App</a>.</span>
                </footer>
            </div>
        </div>
    </body>
</html>


<!-- Common layout structure -->
