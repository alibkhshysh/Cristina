## Render Option 2 Setup (Free)

This repo is prepared for Render Docker deployment with:

- Service name: `CristinaPiccola`
- Runtime: Docker (Tomcat + WAR)
- Health check: `/Cristina`
- Blueprint file: `render.yaml`

### Final steps you must do in Render UI

1. Push this repo to GitHub (`main` branch).
2. In Render: `New` -> `Blueprint`.
3. Select this GitHub repo.
4. Confirm the service name is `CristinaPiccola`.
5. Click `Apply`.

### Public URL

Render URL will be:

- `https://cristinapiccola.onrender.com`

Then open:

- `https://cristinapiccola.onrender.com/Cristina`

### Important

- Render uses lowercase for the generated subdomain.
- The exact subdomain must be available. If already taken, Render will require a different service name.
- Free instances sleep after inactivity and may take a few seconds to wake up.
