document.addEventListener('keyup', e => {
	if(e.target.matches('#buscador')){
		document.querySelectorAll('.festival').forEach(festival => {
			festival.textContent.toLowerCase().includes(e.target.value) 
			? festival.classList.remove('filtro')
			: festival.classList.add('filtro');
		})
	}
})